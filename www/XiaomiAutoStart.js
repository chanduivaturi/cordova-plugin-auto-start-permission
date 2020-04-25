var exec = require('cordova/exec');

function AutoStartPermission() {

}

AutoStartPermission.prototype.isAutoStartPermissionAvailable = function() {
    exec(function(res){}, function(err){}, "AutoStartPermission", "isAutoStartPermissionAvailable", []);
}

AutoStartPermission.prototype.hasPermission = function() {
    exec(function(res){}, function(err){}, "AutoStartPermission", "getAutoStartPermission", []);
}

module.exports = new AutoStartPermission();