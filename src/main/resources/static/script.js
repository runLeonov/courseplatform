const grade = document.querySelector('.grade')
const nextLesson = document.querySelector('#next')


calc.onclick = function() {
    var myform = this.form
    let val = 0;
    val = +myform.var1.value + +myform.var2.value + 
    +myform.var3.value + +myform.var4.value + +myform.var5.value + 
    +myform.var6.value + +myform.var7.value + +myform.var8.value + 
    +myform.var9.value + +myform.var10.value
    grade.innerHTML = val
    if (val == 7 || val > 7) {
        nextLesson.classList.add('checked')
    }
}

res.onclick = () => {
    grade.innerHTML = 0
}