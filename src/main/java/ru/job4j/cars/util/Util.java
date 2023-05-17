package ru.job4j.cars.util;

import org.springframework.ui.Model;
import ru.job4j.cars.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;

/**
 * Oywayten 23.03.2023.
 */
public final class Util {

    private Util() {
    }

    public static void setUserAndTimezoneToSession(Model model, HttpSession httpSession) {
        setSessionUserToModel(model, httpSession);
        setSessionTimezoneToModel(httpSession, model);
    }

    public static void setSessionUserToModel(Model model, HttpSession httpSession) {
        User user = getSessionUser(httpSession);
        user = setLoginGuestIfUserIsNull(user);
        model.addAttribute("user", user);
    }

    public static User getSessionUser(HttpSession httpSession) {
        return (User) httpSession.getAttribute("user");
    }

    private static void setSessionTimezoneToModel(HttpSession httpSession, Model model) {
        String timezone = getSessionUser(httpSession).getTimezone();
        if (null == timezone) {
            timezone = TimeZone.getDefault().toZoneId().toString();
        }
        model.addAttribute("timezone", timezone);
    }

    private static User setLoginGuestIfUserIsNull(User user) {
        if (user == null) {
            user = new User();
            user.setLogin("guest");
        }
        return user;
    }

    public static List<TimeZone> getAvailableTimeZones() {
        return Arrays.stream(TimeZone.getAvailableIDs())
                .map(TimeZone::getTimeZone)
                .sorted(Comparator.comparingInt(TimeZone::getRawOffset))
                .toList();
    }

    public static String refreshPage(HttpServletRequest request) {
        return String.format("%s%s", "redirect:", request.getHeader("referer"));
    }

    public static String goToError(Model model, String message) {
        model.addAttribute("message", message);
        return "/error";
    }
}
