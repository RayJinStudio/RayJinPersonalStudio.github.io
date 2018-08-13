function signup() {
 
           Bmob.initialize("4bc97a68f8d809e08030fce8f2768548", "554702d0136960cb5f133f9916f0eb38");

            var user1 = document.getElementById("user").value;
           
 
       var paw = document.getElementById("paw").value;
 var paw2 = document.getElementById("paw2").value;
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
           }else
	{alert("两次输入不一致")}
        }

