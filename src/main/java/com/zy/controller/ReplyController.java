package com.zy.controller;

import com.zy.dto.*;
import com.zy.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("/reply")
@Controller
public class ReplyController {

	@Autowired
	private MessageServiceInter messageService;
	@Autowired
	private CommentServiceInter commentService;
	@Autowired
	private CommentReplyServiceInter commentReplyService;
	@Autowired
	private MessageReplyServiceInter messageReplyService;
	@Autowired
	private RecipeServiceInter recipeService;
	@Autowired
	private UserServiceInter userService;
	
	@RequestMapping("/submitMessage")
	public String submitMessage(String messageContent,int user_id,HttpSession session,HttpServletResponse response) throws IOException {
		
		User loginuser = (User) session.getAttribute("loginuser");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if(loginuser==null){
			out.write("<script>alert(\"Please Login\");window.location.href=\"/info/goLoginView.action\";</script>");
			return null;
		}
		Message message = new Message();
		message.setId(1);
		message.setContent(messageContent);
		message.setUserByWriterId(loginuser);
		message.setUserByReceiverId((User)userService.findById(User.class, user_id));
		SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		message.setTimestamp(dateFormat.format(new Date()));
		messageService.add(message);
		out.write("<script>alert(\"Comment Success\");window.location.href=\"/info/goUserIndex.action?user_id="+user_id+"\";</script>");
		return null;
	}
	
	@RequestMapping("/submitMessageReply")
	public ModelAndView submitMessageReply(String messageContent,int message_id,int user_id,HttpSession session,HttpServletResponse response) throws IOException {
		
		User loginuser = (User) session.getAttribute("loginuser");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if(loginuser==null){
			out.write("<script>alert(\"Please Login\");window.location.href=\"/info/goLoginView.action\";</script>");
			return null;
		}
		Message message = (Message) messageService.findById(Message.class, message_id);
		Messagereply messagereply = new Messagereply();
		SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		messagereply.setId(1);
		messagereply.setTimestamp(dateFormat.format(new Date()));
		messagereply.setContent(messageContent);
		messagereply.setMessage(message);
		messagereply.setUserByReceiverId(message.getUserByWriterId());
		messagereply.setUserByWriterId(loginuser);
		messageReplyService.add(messagereply);
		out.write("<script>alert(\"Reply Success\");window.location.href=\"/GreenKitchen/info/goUserIndex.action?user_id="+user_id+"\";</script>");
		return null;
	}
	
	@RequestMapping("/submitComment")
	public ModelAndView submitComment(String recipeComment,int recipe_id,HttpSession session,HttpServletResponse response) throws IOException {
		
		User loginuser = (User) session.getAttribute("loginuser");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if(loginuser==null){
			out.write("<script>alert(\"Please Login\");window.location.href=\"/GreenKitchen/info/goLoginView.action\";</script>");
			return null;
		}
		Comment comment = new Comment();
		comment.setId(1);
		comment.setContent(recipeComment);
		SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		comment.setTimestamp(dateFormat.format(new Date()));
		comment.setRecipe((Recipe)recipeService.findById(Recipe.class, recipe_id));
		comment.setUser(loginuser);
		commentService.addCommentAndUpdateCommentNum(comment);
		out.write("<script>alert(\"Comment Success\");window.location.href=\"/GreenKitchen/recipe/goRecipeDetail.action?recipe_id="+recipe_id+"\";</script>");
		return null;
	}
	
	@RequestMapping("/submitCommentReply")
	public ModelAndView submitCommentReply(String recipeComment,int comment_id,int recipe_id,HttpSession session,HttpServletResponse response) throws IOException {
		
		User loginuser = (User) session.getAttribute("loginuser");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if(loginuser==null){
			out.write("<script>alert(\"Please Login\");window.location.href=\"/GreenKitchen/info/goLoginView.action\";</script>");
			return null;
		}
		Commentreply commentreply = new Commentreply();
		commentreply.setId(1);
		Comment comment = (Comment)commentService.findById(Comment.class, comment_id);
		commentreply.setComment(comment);
		commentreply.setContent(recipeComment);
		SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		commentreply.setTimestamp(dateFormat.format(new Date()));
		commentreply.setUserByReceiverId(comment.getUser());
		commentreply.setUserByWriterId(loginuser);
		commentReplyService.add(commentreply);
		out.write("<script>alert(\"Reply Success\");window.location.href=\"/GreenKitchen/recipe/goRecipeDetail.action?recipe_id="+recipe_id+"\";</script>");
		return null;
	}
	
}
