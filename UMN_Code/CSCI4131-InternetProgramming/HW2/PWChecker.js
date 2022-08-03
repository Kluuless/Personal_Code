var pwWidget = document.querySelector("th input");
var pwStrText = document.getElementById("PWStrength");
var strBarWidth = document.getElementsByClassName("PWChecker")[0];
var strBarColor = document.querySelector("th table tr th");
var lcLetters = "abcdefghijklmnopqrstuvwxyz";
var ucLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
var numbers = "1234567890";
var specChars = "`~!@#$%^&*()_-+=[{]}\\|;:'\",<.>/?";

function strCount(word, matches) {
	let count = 0;
	for (let i = 0; i < word.length; i++) {
		for (let j = 0; j < matches.length; j++) {
			if (word.charAt(i) == matches.charAt(j)) {
				count++;
			}
		}
	}
	return count;
}

pwWidget.addEventListener("keyup",function(event) {
	let pw = pwWidget.value;
	let strength = 0;
	
	//get counts
	let lcs = strCount(pw,lcLetters);
	let ucs = strCount(pw,ucLetters);
	let nums = strCount(pw,numbers);
	let specs = strCount(pw,specChars);
	
	//use the counts
	if (lcs + ucs + nums > 0) {
		strength++;
	}
	if (specs == 1) {
		strength++;
	} else if (specs > 1) {
		strength += 2;
	}
	
	//use password length
	if (pw.length == 0) {
		strength = 0;
	} else if (pw.length < 6) {
		strength = -1;
	} else if (pw.length > 7) {
		strength++;
	}
	
	//determine strength
	if (strength == -1) {
		pwStrText.innerHTML = "(Too short)";
		pwStrText.style.color = "red";
		strBarWidth.style.width = "12%";
		strBarColor.style.backgroundColor = "red";
		strBarColor.style.border = "1px solid red";
	} else if (strength == 0) {
		pwStrText.innerHTML = "(Empty)";
		pwStrText.style.color = "rgb(0,50,100)";
		strBarWidth.style.width = "60%";
		strBarColor.style.backgroundColor = "rgb(225,200,255)";
		strBarColor.style.border = "1px solid rgb(0,50,100)";
	} else if (strength < 2) {
		pwStrText.innerHTML = "(Weak)";
		pwStrText.style.color = "orange";
		strBarWidth.style.width = "24%";
		strBarColor.style.backgroundColor = "orange";
		strBarColor.style.border = "1px solid orange";
	} else if (strength == 2) {
		pwStrText.innerHTML = "(Good)";
		pwStrText.style.color = "yellow"
		strBarWidth.style.width = "48%";
		strBarColor.style.backgroundColor = "yellow";
		strBarColor.style.border = "1px solid yellow";
	} else {
		pwStrText.innerHTML = "(Strong)";
		pwStrText.style.color = "green";
		strBarWidth.style.width = "60%";
		strBarColor.style.backgroundColor = "green";
		strBarColor.style.border = "1px solid green";
	}
});