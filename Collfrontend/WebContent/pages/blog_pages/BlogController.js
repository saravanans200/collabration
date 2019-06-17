myApp.controller("BlogController",function($scope,$location,$rootScope,$http)
{
	$scope.blog={"blogid":0,"blogName":"","blogContent":"","username":"","createDate":"","status":"","likes":0,"dislikes":0};
	
	$rootScope.blogdata;
	
	$rootScope.blogid;
	
	$scope.addBlog=function()
	{
		$scope.blog.username=$rootScope.currentUser.username;
		$http.post('http://localhost:8091/CollMiddleware/addBlog',$scope.blog)
		.then(function(response)
		{
			console.log('Blog Added');
			alert("Blog Added Successfully");
			$location.path("/addBlog");
		},
		function(errresponse)
		{
		console.log('Error occured to add a blog');
		alert("Error occured while adding Blog");
		$location.path("/addBlog");
		});
	}
	
	function listBlogs()
	{
		console.log('List Blog Method');
		
		$http.get('http://localhost:8091/CollMiddleware/showAllBlogs')
		.then(function(response){
			console.log('Showing all the Blog');
			$scope.blogdata=response.data;
		},
		function(errresponse){
			console.log('Error Occured');
		});
	}
	
	
	
	$scope.incrementLikes=function(blogid)
	{
		console.log('Incremented Likes');
		$http.get('http://localhost:8091/CollMiddleware/incrementLikes/'+blogid)
		.then(function(response)
		{
			listBlogs();
			$location.path("/showBlog");
		},
		function(errresponse){
			console.log('Error Occured');
		});
		
	}
	$scope.incrementDisLikes=function(blogid)
	{
		console.log('Incremented dislikes');
		$http.get('http://localhost:8091/CollMiddleware/incrementDisLikes/'+blogid)
		.then(function(response)
		{
			listBlogs();
			$location.path("/showBlog");
		},
		function(errresponse){
			console.log('Error Occured');
		});
		
	}
	$scope.deleteBlog=function(blogid)
	{
		console.log('Blog Deleted');
		$http.get('http://localhost:8091/CollMiddleware/deleteBlog/'+blogid)
		.then(function(response)
				{
			listBlogs();
			alert('Blog Deleted');
			$location.path("/showBlog");
				},
				function(errresponse)
				{
					console.log('Error Occured');
					alert('Error Occured while Deleting Blog');
			
				});	
	}
	$scope.approve=function(blogid)
	{
		console.log('Blog Approved');
		$http.get('http://localhost:8091/CollMiddleware/approveBlog/'+blogid)
		.then(function(response)
				{
			listBlogs();
			alert('Blog Approved');
			$location.path("/adminBlog");
				},
				function(errresponse)
				{
					console.log('Error Occured');
					alert('Error Occured while Approving Blog');
			
				});	
	}
	
	$scope.reject=function(blogid)
	{
		console.log('Blog Rejected');
		$http.get('http://localhost:8091/CollMiddleware/rejectBlog/'+blogid)
		.then(function(response)
				{
			listBlogs();
			alert('Blog Rejected');
			$location.path("/adminBlog");
				},
				function(errresponse)
				{
					console.log('Error Occured');
					alert('Error Occured while Rejecting Blog');
			
				});	
	}
	$scope.editBlog=function(blogid)
	{
		console.log('Editing a Blog');
		$rootScope.blogid=blogid;
		$location.path("/updateBlog");
	}
	function getBlog()
	{
		console.log('getting a Blog');
		$http.get('http://localhost:8091/CollMiddleware/getBlog/'+$rootScope.blogid)
		.then(function(response)
				{
			
					$scope.blog=response.data;
				});
	}
	getBlog();
	
	listBlogs();
	});