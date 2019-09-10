Java.perform(function () {
    var mainClass = Java.use("me.shingle.fridatest.MainActivity")

    mainClass.Add.implementation = function (a1, a2) {
        console.log("a1:" + a1)
        console.log("a2:" + a2)

        var result = this.Add(a1, a2)

        console.log("result:" + result)

        return result
    }
})
