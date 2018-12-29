function selectRole(idcount, id) {
    var selectedValue = document.getElementById(idcount).value;
    var showRoleId = "hh" + idcount;
    var index = document.getElementById(idcount).selectedIndex;
    document.getElementById(showRoleId).innerHTML = document.getElementById(idcount).options[index].text;
    $.getJSON("/roleController/changeRole", {"usertype": selectedValue, "id": id}, function (data) {

    })
}


$('#addRole').click(function () {
    var newRoleName = $('#exampleInputName2').val();
    $.getJSON('../roleController/addRole', {"rolename": newRoleName}, function (data) {
        if (data == 0) {
            alert("用户角色不能为空！");
        } else {
            location.href = "../mainController/toRolePower";
            alert("新增成功！");
        }
    })
})

$('.addRolePower').click(function () {
    var selectRoleValue = document.getElementById("selectRole").value;
    var selectPowerValue = document.getElementById("selectPower").value;

    $.getJSON('../roleController/addPowerOfRole', {
        "powerId": selectPowerValue,
        "roleId": selectRoleValue
    }, function (data) {
        if (data === 1) {
            alert("请将角色名或权限名选择清楚！")
        } else if (data === 2) {
            alert("角色权限添加成功！")
            location.href = "../mainController/toRolePower"
        } else if (data === 3) {
            alert("该权限已经存在该角色中！")
        }
    })
})



$(function () {
    $(".leftnav h2").click(function () {
        $(this).next().slideToggle(200);
        $(this).toggleClass("on");
    })
    $(".leftnav ul li a").click(function () {
        $("#a_leader_txt").text($(this).text());
        $(".leftnav ul li a").removeClass("on");
        $(this).addClass("on");
    })
});