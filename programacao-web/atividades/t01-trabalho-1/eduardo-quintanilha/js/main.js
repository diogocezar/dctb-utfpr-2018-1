

function formSubmit(){
    var name = document.querySelector('#name').value;
    var email = document.querySelectorAll('#email').value;
    var subject = document.querySelectorAll('#subject').value;
    var message = document.querySelectorAll('#message').value;
    console.log(name);
    if(name != '' && email != '' && message != ''){
        alert('Form Ok!');
    }else{   
        var validateMessage = document.getElementById('validate-message').innerHTML = '<br>Incorrect Data! Try again.<br>';
    }
}

