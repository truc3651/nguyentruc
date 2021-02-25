
$(document).ready(function(){
  // Add smooth scrolling to all links
  $("a").on('click', function(event) {

    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {
      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (800) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 800, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
});

function validation(){
	var form = document.forms["form"]
	var fullname = form["fullname"].value
	var email = form["email"].value
	var phoneNumber = form["phoneNumber"].value
	var message = form["message"].value
	
	var patternEmail = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	var patternFullname = /^[A-Z]([-']?[a-z]+)*( [A-Z]([-']?[a-z]+)*)+$/
	var patternPhone = /(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})\b/
	
	if (fullname == "") 
        $("#errFullname").text("Fullname is required");
    else if(!fullname.match(patternFullname))
    	$("#errFullname").text("Fullname is not right");
    else $("#errFullname").text("");
    

    if (email == "") 
        $("#errEmail").text("Email is required");
    else if (!email.match(patternEmail)) 
        $("#errEmail").text("Email is invalid");
    else $("#errEmail").text("");

    
    if (phoneNumber == "") 
        $("#errPhone").text("Phone number is required");
    else if(!phoneNumber.match(patternPhone))
    	$("#errPhone").text("Phone number is not right");
    else $("#errPhone").text("");

	
	if (message == "") 
        $("#errMess").text("Message is required");
    else $("#errMess").text("");


    if ($("#errFullname").text() == "" &&
        $("#errEmail").text() == "" &&
        $("#errPhone").text() == "" &&
        $("#errMess").text() == "")
    	
		return true

    return false;
}
