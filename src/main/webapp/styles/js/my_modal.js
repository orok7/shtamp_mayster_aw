function my_modal(blockId, closeBtnId) {
    var block1 = document.getElementById(blockId);
    var closeBtn = document.getElementById(closeBtnId);

    closeBtn.onclick = function () {
        block1.style.display = "none";
    }

    window.onclick = function (event) {
        console.log(event.target);
        console.log(block1);
        if (event.target == block1) {
            block1.style.display = "none";
        }
    }
    /*block.onclick = function () {
            block.style.display = "none";
    }*/
}