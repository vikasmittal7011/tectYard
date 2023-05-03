// Home page

function errorInDownload() {
    if ($(".hide").css("display") === 'none') {
        $(".hide").addClass("unhide");
        $(".unhide").removeClass("hide");
    } else {
        $(".unhide").addClass("hide");
        $(".hide").removeClass("unhide");
    }
}

// Validate Registeration Form

function validateRegisterationForm() {

    let firstName = $("#U_Name").val();
    let lastName = $("#U_Name_Sur").val();
    let age = $("#U_Age").val();
    let email = $("#U_Email").val();
    let contactNumber = $("#U_Contact").val();
    let password = $("#U_Password").val();
    let confirmPassword = $("#U_Password_Confirm").val();

    let atTheRatePosition = email.indexOf("@");
    let dotPosition = email.indexOf(".");
    let firstDigitOfContact = parseInt(contactNumber.charAt(0));

    if (firstName.length < 2) {
        alert("Please enter first name correctly");
        return false;
    } else if (lastName.length < 2) {
        alert("Plase enter last name correctly");
        return false;
    } else if (age < 16) {
        alert("Age must be greater than 16");
        return false;
    } else if (email.length < 5 || atTheRatePosition < 7 || dotPosition < atTheRatePosition + 2) {
        alert("Enter email correctly");
        return false;
    } else if (contactNumber.length < 10 || contactNumber.length > 11) {
        alert("Contact number must 10 Digits");
        return false;
    } else if (firstDigitOfContact < 6) {
        alert("Contact must be start with 6,7,8 or 9 ");
        return false;
    } else if (password.length < 8 || password.length > 12) {
        alert("Password must be in between 8 to 12");
        return false;
    } else if (confirmPassword != password) {
        alert("Password must be same");
        return false;
    } else {
        return true;
    }
}

// Validate Login Form

function validateLoginForm() {
    // alert("Hello");
    let email = $("#U_Email_").val();
    let password = $("#U_Password_").val();

    let atTheRatePosition = email.indexOf("@");
    let dotPosition = email.indexOf(".");

    if (email.length < 5 || atTheRatePosition < 7 || dotPosition < atTheRatePosition + 2) {
        alert("Enter email correctly");
        return false;
    } else if (password.length < 8 || password.length > 12) {
        alert("Password must be in between 8 to 12");
        return false;
    }
}

// Validate Details Update Form 

function validateUpdationUserDetailsForm() {
    let name = $("#U_Name").val();
    let age = $("#U_Age").val();
    let contactNumber = $("#U_Contact").val();
    let houseNo = parseInt($("#U_HouseNo").val());
    let street = $("#U_Street").val();
    let city = $("#U_City").val();
    let state = $("#U_State").val();
    let pincode = $("#U_Pincode").val();

    let fullName = name.indexOf(" ");
    let firstDigitOfContact = parseInt(contactNumber.charAt(0));

    if (name.length < 4) {
        alert("Please enter name");
        return false;
    } else if (fullName < 4) {
        alert("Please enter full name");
        return false;
    } else if (age < 16) {
        alert("Age must be greater than 16");
        return false;
    } else if (contactNumber.length < 10 || contactNumber.length > 11) {
        alert("Contect number must be 10 digits");
        return false;
    } else if (firstDigitOfContact < 6) {
        alert("Contact must be start with 6,7,8 or 9 ");
        return false;
    } else if (houseNo < 1) {
        alert("Please enter house number");
        return false;
    } else if (street.length < 3) {
        alert("Please enter street");
        return false;
    } else if (city.length < 5) {
        alert("Please enter city");
        return false;
    } else if (state.length < 3) {
        alert("Please enter state");
        return false;
    } else if (pincode.length < 5 || pincode.length > 10) {
        alert("Please enter pincode");
        return false;
    } else if (parseInt(pincode) < 00501) {
        alert("Please enter valid pincode");
        return false;
    }

    return true;
}

// Validate Password Chanage Form

function validateChangePasswordForm() {
    let password = $("#U_Password").val();
    let confirmPassword = $("#U_Password_Confirm").val();
    let email = $("#U_Email").val();

    let atTheRatePosition = email.indexOf("@");
    let dotPosition = email.indexOf(".");

    if (email.length < 5 || atTheRatePosition < 7 || dotPosition < atTheRatePosition + 2) {
        alert("Enter email correctly");
        return false;
    } else if (password.length < 8 || password.length > 12) {
        alert("Passowrd must e in between 8 - 12");
        return false;
    } else if (password != confirmPassword) {
        alert("Password must be same");
        return false;
    }
    return true;
}

// Validate Feed back Form

function validateFeedBackForm() {
    let comment = $("#F_Comment").val();

    if (comment.length < 20 || comment.length > 150) {
        alert("Comment should be in between 20 - 150");
        return false;
    } else {
        return true;
    }
}

// Validate Add Product Form

function validateAddProductForm() {
    let name = $("#P_Name").val();
    let price = parseInt($("#P_Price")).val();
    let info = $("#P_Info").val();

    if (name.length < 3) {
        alert("Pleas enter name of product correctly");
        return false;
    } else if (price < 20) {
        alert("Please enter correct price");
        return false;
    } else if (info.length > 150) {
        alert("Plese enter info under 150 words");
        return false;
    } else {
        return true;
    }
}

// Count the word of info

function countNumberOfWords(){
    let getString = document.getElementById("P_Info").value;
    console.log("a");
    if(getString.length == 149){
        alert("Word limit of info is reached");
    }
}