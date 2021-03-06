var myApp=angular.module("myApp",['ngRoute','ngCookies']);

myApp.config(function($routeProvider)
		{
	
	$routeProvider
	.when("/index",{templateUrl:"index.html"})
	.when("/login",{templateUrl:"pages/user_pages/Login.html"})
	.when("/register",{templateUrl:"pages/user_pages/Register.html"})
	.when("/aboutus",{templateUrl:"pages/user_pages/About_us.html"})
	.when("/contactus",{templateUrl:"pages/user_pages/Contact_us.html"})
	.when("/profileUpload",{templateUrl:"pages/user_pages/ProfileUpload.html"})
	
	.when("/blog",{templateUrl:"pages/blog_pages/blog.html"})
	.when("/addBlog",{templateUrl:"pages/blog_pages/AddBlog.html"})
	.when("/showBlog",{templateUrl:"pages/blog_pages/ShowBlog.html"})
	.when("/manageBlog",{templateUrl:"pages/blog_pages/ManageBlog.html"})
	.when("/showBlogComment",{templateUrl:"pages/blog_pages/BlogComment.html"})
	
	.when("/chat",{templateUrl:"pages/chat_pages/Chat.html"})
	
	.when("/friend",{templateUrl:"pages/friend_pages/Friend.html"})
	
	.when("/showForum",{templateUrl:"pages/forum_pages/ShowForum.html"})
	.when("/addForum",{templateUrl:"pages/forum_pages/AddForum.html"})
	.when("/manageForum",{templateUrl:"pages/forum_pages/ManageForum.html"})
	.when("/updateForum",{templateUrl:"pages/forum_pages/updateForum.html"})
	.when("/forumComment",{templateUrl:"pages/forum_pages/ForumComment.html"})
	.when("/showForumComment",{templateUrl:"pages/forum_pages/ForumComment.html"})
	
	
	
	.when("/job",{templateUrl:"pages/job_pages/job.html"})
	.when("/showJob",{templateUrl:"pages/job_pages/showJob.html"});
	
		});

myApp.run(function($rootScope,$cookieStore)
		{
	console.log('I am in run Function');
	
	if($rootScope.currentUser==undefined)
		{
		
		$rootScope.currentUser=$cookieStore.get('userDetail');
		console.log('I am in run Scope');
		}
		});