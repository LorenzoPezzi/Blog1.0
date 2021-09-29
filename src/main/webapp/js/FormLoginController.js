/**
 * 
 */
var controller =
{
	handleChange:function()
	{
		
		let valid = PersonalLibrary.validPassword(loginForm.password.value) 	&&
					PersonalLibrary.validNickname(loginForm.username.value)	;
					
		loginForm.savebutton.disabled = !valid;
		if(valid){
			PersonalLibrary.cryptPassword(loginForm.password.value).then(function(v) {
			    console.log(v); // "fulfilled!"
				loginForm.cryptPass.value = v;
			  }, function() {
			    // not called
			});
		}
	},
	init:function()
	{
		// INIT: collega gli eventi al codice
		loginForm.password.onchange 	= controller.handleChange;
		loginForm.username.onchange 	= controller.handleChange; 	 
	}		
}
// ESEGUO ASSOCIAZIONE EVENTI E CODICE
controller.init();