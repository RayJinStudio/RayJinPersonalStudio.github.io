       function readtext() {
 
           Bmob.initialize("7e8ce97c90d7014bb2cc0e0a2e9b5260", "49b35cbc0308f74a39391c382d2c176a");

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

 
