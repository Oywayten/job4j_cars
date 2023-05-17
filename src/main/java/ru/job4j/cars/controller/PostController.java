package ru.job4j.cars.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.cars.dto.FileDto;
import ru.job4j.cars.dto.PostForm;
import ru.job4j.cars.model.*;
import ru.job4j.cars.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static ru.job4j.cars.util.Util.*;

/**
 * Oywayten 13.05.2023.
 */
@Controller
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;
    private final CategoryService categoryService;
    private final CarModelService carModelService;
    private final BodyTypeService bodyTypeService;
    private final EngineService engineService;
    private final CarService carService;
    private final FileService fileService;


    @GetMapping
    public String showPosts(Model model, HttpSession httpSession) {
        setUserAndTimezoneToSession(model, httpSession);
        model.addAttribute("posts", postService.findAll());
        return "/post/list";
    }

    @GetMapping("/last-day")
    public String showPostsForLastDay(Model model, HttpSession httpSession) {
        setUserAndTimezoneToSession(model, httpSession);
        model.addAttribute("posts", postService.findAllForLastDay());
        return "/post/lastDayList";
    }

    @GetMapping("/with-photo")
    public String showPostsWithPhoto(Model model, HttpSession httpSession) {
        setUserAndTimezoneToSession(model, httpSession);
        model.addAttribute("posts", postService.findAllWithPhoto());
        return "/post/withPhotoList";
    }

    @GetMapping("/by-brand")
    public String showPostsByBrand(@RequestParam String brand, Model model, HttpSession httpSession) {
        setUserAndTimezoneToSession(model, httpSession);
        model.addAttribute("posts", postService.findAllByBrand(brand));
        return "/post/byBrandList";
    }

    @GetMapping("/add-form")
    public String initAddForm(Model model, HttpSession httpSession) {
        setUserAndTimezoneToSession(model, httpSession);
        model.addAttribute("bodyTypes", bodyTypeService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("carModels", carModelService.findAll());
        model.addAttribute("engines", engineService.findAll());
        return "/post/addForm";
    }

    @PostMapping("/create")
    public String create(Model model, @ModelAttribute PostForm postForm, @RequestParam MultipartFile multipartFile, HttpSession httpSession) {
        Post post = getPostByPostForm(postForm);
        if (multipartFile.getSize() > 0) {
            setFileToPost(multipartFile, post);
        }

        User user = getSessionUser(httpSession);
        post.setUser(user);
        if (postService.add(post).isEmpty()) {
            setSessionUserToModel(model, httpSession);
            return goToError(model, String.format("Post creation error with description = %s",
                    post.getDescription()));
        }
        return "redirect:/posts";
    }

    private void setFileToPost(MultipartFile multipartFile, Post post) {
        Optional<File> fileOptional = getFileOptionalFromMultipartFile(multipartFile);
        if (fileOptional.isPresent()) {
            File file = fileOptional.get();
            post.setPhoto(file);
        }
    }

    private Optional<File> getFileOptionalFromMultipartFile(MultipartFile multipartFile) {
        Optional<File> fileOptional;
        try {
            FileDto fileDto = new FileDto(multipartFile.getOriginalFilename(), multipartFile.getBytes());
            fileOptional = fileService.add(fileDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileOptional;
    }

    private Post getPostByPostForm(PostForm postForm) {
        Optional<Category> categoryOptional = categoryService.findById(postForm.getCategoryId());
        Optional<CarModel> carModelOptional = carModelService.findById(postForm.getCarModelId());
        Optional<BodyType> bodyTypeOptional = bodyTypeService.findById(postForm.getBodyTypeId());
        Optional<Engine> engineOptional = engineService.findById(postForm.getEngineId());
        Car car = new Car();
        if (categoryOptional.isPresent() && carModelOptional.isPresent()
                && bodyTypeOptional.isPresent() && engineOptional.isPresent()) {
            car.setCategory(categoryOptional.get());
            car.setCarModel(carModelOptional.get());
            car.setBodyType(bodyTypeOptional.get());
            car.setEngine(engineOptional.get());
        }
        Post post = new Post();
        Optional<Car> carOptional = carService.add(car);
        car = carOptional.orElseThrow();
        post.setCar(car);
        post.setDescription(postForm.getDescription());
        return post;
    }

    @PostMapping("/car-sold")
    public String setPostStatusSold(@RequestParam Long postId, Model model, HttpSession httpSession, HttpServletRequest request) {
        User user = getSessionUser(httpSession);
        boolean isNotSuccessSetSoldStatus = !postService.setPostStatusSold(postId, user.getId());
        if (isNotSuccessSetSoldStatus) {
            setSessionUserToModel(model, httpSession);
            return goToError(model, String.format("Error set post's status sold for post with id = %d", postId));
        }
        return refreshPage(request);
    }
}
