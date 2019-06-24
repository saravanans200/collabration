myApp.controller("JobController",function($scope,$location,$rootScope,$http,$cookieStore)
{
	$scope.job={"jobdesignation":"","companyname":"","CTC":"","joblocation":"","lastDate":"","skill":""};
    
	
	
	$rootScope.jobId;
	
	$scope.addJob=function()
	{
		
		$http.post('http://localhost:8080/CollMiddleware/addJob',$scope.job)
		.then(function(response)
		{
			console.log('job added');
			alert("job Added Successfully");
			$location.path("/addJob");
		},
		function(errresponse)
		{
		console.log('Error occured to add a job');
		alert("Error occured while adding job");
		$location.path("/addjob");
		});
	}
});