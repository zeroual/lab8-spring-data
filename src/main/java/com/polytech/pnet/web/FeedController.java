package com.polytech.pnet.web;

import com.polytech.pnet.models.Post;
import com.polytech.pnet.services.FeedService;
import com.polytech.pnet.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class FeedController {

    @Autowired
    private PublicationService publicationService;

    @Autowired
    private FeedService feedService;

    @RequestMapping(value = "/feed", method = RequestMethod.POST)
    public String post(Post post) {
        publicationService.post(post);
        return "redirect:/feed";
    }

    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public String home(Model model) {
        List<Post> posts = feedService.fetchFeeds();
        model.addAttribute("posts", posts);
        return "feed";
    }

    @RequestMapping(value = "/feed/{id}", method = RequestMethod.GET)
    public Post fetchPost(@PathVariable("id") Long id) {
        return feedService.fetchFeed(id);
    }
}
