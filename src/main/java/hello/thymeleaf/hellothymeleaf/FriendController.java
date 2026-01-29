package hello.thymeleaf.hellothymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FriendController {

    private List<Friend> friends = new ArrayList<>();

    public FriendController() {

        friends.add(new Friend("John", "Doe"));
        friends.add(new Friend("Jane", "Smith"));
    }

    @GetMapping("/friends")
    public String friendsList(Model model) {
        model.addAttribute("friends", friends);
        return "friends";
    }

    @GetMapping("/add")
    public String addFriendForm(Model model) {
        model.addAttribute("friend", new Friend());
        return "addfriend";
    }

    @PostMapping("/add")
    public String addFriendSubmit(@ModelAttribute Friend friend, Model model) {
        friends.add(friend);
        model.addAttribute("friends", friends);
        return "friends";
    }
}
