<<<<<<< HEAD
var PersonalLibrary = {
	validPassword: function(s){
		if(!s)
			return false;
		if(s.length<8)
			return false;
		if(typeof s != "string")
			return false;
		if(s==s.toLowerCase() || s==s.toUpperCase())
			return false;
		for(let i = 0; i<s.length; i++)
			if(!PersonalLibrary.validPasswordChar(s[i]))
				return false;
		return true;
	},
	validPasswordChar: function(c){
		validChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		validChar += validChar.toLowerCase();
		validChar += "0123456789_.";
		for(let i = 0; i<validChar.length; i++)
			if(c == validChar[i])
				return true;
		return false;
	},validEmail:function(s){
        if(!s)   //se s non è passata
            return false;
        // i TIPI sono opzionali. Potrei non passare una stringa!!
        if(typeof s !='string')       //se non passo una stringa 
            return false;
        if(s.length < 5)      //controllo se email lunga almeno 5 caratteri
            return false;
        let emailarray = s.split("@");         //splitto l'email per @'
        if(emailarray.length != 2 || emailarray[0] == "") //splitto per @ e devono esserci 2 "elementi"(prima e dopo@) e se il primo è "vuoto":
            return false;
        let left = emailarray[0].split(".");    // splitto il primo elemento pre @ per .
        for(let i = 0; i<left.length;i++)       // scorro left
            if(left[i] == "")                   // se c'è spazio vuoto significa che ci sono due . attaccati '
            return false;
        let right = emailarray[1].split(".");   //splitto il secondo elemento post @ per .
        if(right.length != 2 || right[0] == "" || right[1] == "") //splitto il secondo elemento per il punto e controllo se ha ancora due elementi return false
            return false;
        s= s.replaceAll(".","") //sostituisco . e @ che non stanno su validchar
        s= s.replace("@","")

        console.log(s);

        for(let i=0;i<s.length;i++) //ciclo lunghezza di s
           if(!PersonalLibrary.validPasswordChar(s[i])) //se un elemento non rispetta valid char return false
              return false;
        return true;
    },
	validNickname: function(s){
		if(!s)
			return false;
		// i TIPI sono opzionali. Potrei non passare una stringa!!
		if(typeof s !='string')
			return false;	
		return s.length > 3;
	},
	validDate: function(s){
		if(s.split("/").length != 3)
			return false;
		parts = s.split("/")		
		if((parts[0].length < 1 && parts[0].length>2)||(parts[1].length < 1 && parts[1].length>2)||(parts[2].length !=4))
			return false;
			
		illegalChar = "abcdefghijklmnopqrstuvwxyz"
		illegalChar += illegalChar.toUpperCase()
		illegalChar += '""!"£$%&()=?^*+\[]{}'
		
		for(let i = 0; i<s.length;i++)
			for(let j = 0; j < illegalChar.length;j++)	
				if(s[i]==illegalChar[j])
					return false;
		return true;	
	},
	cryptPassword: async function(s){ 
		    const msgBuffer = new TextEncoder().encode(s);                    
		    const hashBuffer = await crypto.subtle.digest('SHA-256', msgBuffer);
		    const hashArray = Array.from(new Uint8Array(hashBuffer));                
		    const hashHex = hashArray.map(b => b.toString(16).padStart(2, '0')).join('');	
		    return hashHex;
	},
	axiosPost: function(url){
					axios.post(url)
					.then(obj => {
					  console.log(obj)				 
					})
					.catch(error => {
					  alert("Error "+ error);
					})
				}			
=======
var PersonalLibrary = {
	validPassword: function(s){
		if(!s)
			return false;
		if(s.length<8)
			return false;
		if(typeof s != "string")
			return false;
		if(s==s.toLowerCase() || s==s.toUpperCase())
			return false;
		for(let i = 0; i<s.length; i++)
			if(!PersonalLibrary.validPasswordChar(s[i]))
				return false;
		return true;
	},
	validPasswordChar: function(c){
		validChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		validChar += validChar.toLowerCase();
		validChar += "0123456789_.";
		for(let i = 0; i<validChar.length; i++)
			if(c == validChar[i])
				return true;
		return false;
	},validEmail:function(s){
        if(!s)   //se s non è passata
            return false;
        // i TIPI sono opzionali. Potrei non passare una stringa!!
        if(typeof s !='string')       //se non passo una stringa 
            return false;
        if(s.length < 5)      //controllo se email lunga almeno 5 caratteri
            return false;
        let emailarray = s.split("@");         //splitto l'email per @'
        if(emailarray.length != 2 || emailarray[0] == "") //splitto per @ e devono esserci 2 "elementi"(prima e dopo@) e se il primo è "vuoto":
            return false;
        let left = emailarray[0].split(".");    // splitto il primo elemento pre @ per .
        for(let i = 0; i<left.length;i++)       // scorro left
            if(left[i] == "")                   // se c'è spazio vuoto significa che ci sono due . attaccati '
            return false;
        let right = emailarray[1].split(".");   //splitto il secondo elemento post @ per .
        if(right.length != 2 || right[0] == "" || right[1] == "") //splitto il secondo elemento per il punto e controllo se ha ancora due elementi return false
            return false;
        s= s.replaceAll(".","") //sostituisco . e @ che non stanno su validchar
        s= s.replace("@","")

        console.log(s);

        for(let i=0;i<s.length;i++) //ciclo lunghezza di s
           if(!PersonalLibrary.validPasswordChar(s[i])) //se un elemento non rispetta valid char return false
              return false;
        return true;
    },
	validNickname: function(s){
		if(!s)
			return false;
		// i TIPI sono opzionali. Potrei non passare una stringa!!
		if(typeof s !='string')
			return false;	
		return s.length > 3;
	},
	validDate: function(s){
		if(s.split("/").length != 3)
			return false;
		parts = s.split("/")		
		if((parts[0].length < 1 && parts[0].length>2)||(parts[1].length < 1 && parts[1].length>2)||(parts[2].length !=4))
			return false;
			
		illegalChar = "abcdefghijklmnopqrstuvwxyz"
		illegalChar += illegalChar.toUpperCase()
		illegalChar += '""!"£$%&()=?^*+\[]{}'
		
		for(let i = 0; i<s.length;i++)
			for(let j = 0; j < illegalChar.length;j++)	
				if(s[i]==illegalChar[j])
					return false;
		return true;	
	},
	cryptPassword: async function(s){ 
		    const msgBuffer = new TextEncoder().encode(s);                    
		    const hashBuffer = await crypto.subtle.digest('SHA-256', msgBuffer);
		    const hashArray = Array.from(new Uint8Array(hashBuffer));                
		    const hashHex = hashArray.map(b => b.toString(16).padStart(2, '0')).join('');	
		    return hashHex;
	},
	axiosPost: function(url){
					axios.post(url)
					.then(obj => {
					  console.log(obj)				 
					})
					.catch(error => {
					  alert("Error "+ error);
					})
				}			
>>>>>>> 05221816458389c629d49feafd7f22ce9b2d909f
}