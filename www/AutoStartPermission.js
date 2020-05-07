var exec = require('cordova/exec');

var AutoStartPermission = {
  dupli: "pluigins0-dupli",
  isAutoStartPermissionAvailable: function() {
    exec(function(res){}, function(err){}, "AutoStartPermission", "isAutoStartPermissionAvailable", []);
  },
  getAutoStartPermission : function() {
    exec(function(res){}, function(err){}, "AutoStartPermission", "getAutoStartPermission", []);
  }
}


//AutoStartPermission.install = function () {
  
    window.AutoStartPermission = AutoStartPermission;
  
    console.log('pluigins1', window.AutoStartPermission);
    console.log('pluigins2', window.AutoStartPermission.getAutoStartPermission);
    //return window.plugins.AutoStartPermission;
  //};
  
  //cordova.addConstructor(AutoStartPermission.install);