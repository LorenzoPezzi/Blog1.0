<<<<<<< HEAD
/**
 * 
 */
var controller =
{
	handleChange:function()
	{
		
		let valid = PersonalLibrary.validPassword(signupForm.password.value) 	&&
					signupForm.password.value==signupForm.password2.value		&&
					PersonalLibrary.validNickname(signupForm.username.value)	&&
					PersonalLibrary.validEmail(signupForm.email.value)			&&
					PersonalLibrary.validDate(signupForm.dob.value)				;
					
		signupForm.savebutton.disabled = !valid;
		if(valid){
			PersonalLibrary.cryptPassword(signupForm.password.value).then(function(v) {
			    console.log(v); // "fulfilled!"
				signupForm.cryptPass.value = v;
			  }, function() {
			    // not called
			});
		}
	},
	handleCrypt:function(){
		signupForm.password.value = PersonalLibrary.cryptPassword(signupForm.password.value);
	},
	init:function()
	{
		// INIT: collega gli eventi al codice
		signupForm.password.onchange 	= controller.handleChange;
		signupForm.password2.onchange 	= controller.handleChange; 
		signupForm.username.onchange 	= controller.handleChange; 
		signupForm.email.onchange 		= controller.handleChange;
		signupForm.dob.onchange 		= controller.handleChange;
		//signupForm.savebutton.onclick 	= controller.handleCrypt();		 
	}		
}
// ESEGUO ASSOCIAZIONE EVENTI E CODICE
=======
/**
 * 
 */
var controller =
{
	handleChange:function()
	{
		
		let valid = PersonalLibrary.validPassword(signupForm.password.value) 	&&
					signupForm.password.value==signupForm.password2.value		&&
					PersonalLibrary.validNickname(signupForm.username.value)	&&
					PersonalLibrary.validEmail(signupForm.email.value)			&&
					PersonalLibrary.validDate(signupForm.dob.value)				;
					
		signupForm.savebutton.disabled = !valid;
		if(valid){
			PersonalLibrary.cryptPassword(signupForm.password.value).then(function(v) {
			    console.log(v); // "fulfilled!"
				signupForm.cryptPass.value = v;
			  }, function() {
			    // not called
			});
		}
	},
	handleCrypt:function(){
		signupForm.password.value = PersonalLibrary.cryptPassword(signupForm.password.value);
	},
	init:function()
	{
		// INIT: collega gli eventi al codice
		signupForm.password.onchange 	= controller.handleChange;
		signupForm.password2.onchange 	= controller.handleChange; 
		signupForm.username.onchange 	= controller.handleChange; 
		signupForm.email.onchange 		= controller.handleChange;
		signupForm.dob.onchange 		= controller.handleChange;
		//signupForm.savebutton.onclick 	= controller.handleCrypt();		 
	}		
}
// ESEGUO ASSOCIAZIONE EVENTI E CODICE
>>>>>>> 05221816458389c629d49feafd7f22ce9b2d909f
controller.init();