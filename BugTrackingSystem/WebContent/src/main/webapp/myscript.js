/**
 * 
 */
 
validateUserName = () => {
	
	var name = document["Login-form"]["username"].value;
    flag=0;
      
	for(i=0;i<name.length;i++)
    {
        if(name[i]=="@"){flag =1;break;}
    }

     if(flag==0)
     {
         document.getElementById("error").innerHTML="<br>"+ "Email ID is Wrong"
          return  false;
        }
	
	return true;
}
validatePassword = () => {
	
	var password = document["Login-form"]["password"].value;
   var flag=0;
   
   
    if(password.length<=6)
    {
        
        document.getElementById("error").innerHTML="<br>"+ "Password should be 7 characters or more "
        return false;
    }
    else{
      num=0;
      alphabet=0;
      specialcharacter=0;
	for(i=0;i<password.length;i++)
    {
        if(password[i]=="@"||password[i]=="$"||password[i]=="#"||password[i]=="*")
        {
            specialcharacter=1;
        }
        else if(isNaN(password[i])==false)
        {
             num=1;
        }
        else 
        {
            alphabet=1;
        }
        if(alphabet==0||num==0||specialcharacter==0)
        {
            document.getElementById("error").innerHTML="<br>"+ "Password should contain special characters,numeric values and alphabets"
return false;
        }
    }
    }


	
	return true;
}
function validateData (){
	
	
	var unflag = validateUserName();
    
    if(unflag==true){
	var pwflag= validatePassword();
    }
    //After Checking from database display if entered username and passswword are present in in DB

	
	
	return false;
}




