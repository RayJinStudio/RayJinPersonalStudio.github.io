function signup() {
 
           Bmob.initialize("7e8ce97c90d7014bb2cc0e0a2e9b5260", "49b35cbc0308f74a39391c382d2c176a");
 var user1 = document.getElementById("user").value;
           
 
       var paw = document.getElementById("paw").value;
 var paw2 = document.getElementById("paw2").value;
 if(paw.length>=8)
 {
 if(paw==paw2)
 {
			var user = new Bmob.User();
user.set("username", user1);
user.set("password", paw);


// other fields can be set just like with Bmob.Object


user.signUp(null, {
  success: function(user) {
	  alert("注册成功");
    // Hooray! Let them use the app now.
  },
  error: function(user, error) {
    // Show the error message somewhere and let the user try again.
    alert("Error: " + error.code + " " + error.message);
  }
});
           }
		   else{
			    alert("两次输入密码不一致");
		   }
		   }
		   else{
			   alert("为了账号安全，密码请不小于8位");
		   }
        }

