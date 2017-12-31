var exec = require('cordova/exec');

function XiaomiAutoStart() {

}

XiaomiAutoStart.prototype.hasPermission = function() {
    exec(function(res){}, function(err){}, "XiaomiAutoStart", "getPermission", []);
}

module.exports = new XiaomiAutoStart();