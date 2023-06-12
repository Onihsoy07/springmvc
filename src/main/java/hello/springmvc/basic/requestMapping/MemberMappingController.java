package hello.springmvc.basic.requestMapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MemberMappingController {

    @GetMapping
    public String user() {
        return "get users";
    }

    @PostMapping
    public String addUser() {
        return "post user";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable int userId) {
        return "get userId = " + userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable int userId) {
        return "patch userId = " + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {
        return "delete userId = " + userId;
    }

}
