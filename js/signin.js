       function readtext() {
 
           Bmob.initialize("4bc97a68f8d809e08030fce8f2768548", "554702d0136960cb5f133f9916f0eb38");

            var user = document.getElementById("user").value;
           
 
       var paw = document.getElementById("paw").value;
 
			Bmob.User.logIn(user, paw, {
  success: function(user) {
    // Do stuff after successful login.
	alert("登陆成功");
  },
  error: function(user, error) {
    // The login failed. Check error to see why.
	alert("Error: " + error.code + " " + error.message);
  }
});
           
        }

