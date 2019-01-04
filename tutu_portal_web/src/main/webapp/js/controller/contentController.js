app.controller('contentController',function ($scope,contentService) {

    //根据分类的id获取该分类下的所有广告数据

    $scope.contentList = []; //必须先声明数据

    $scope.findByCategoryId = function (id) {
        contentService.findByCategoryId(id).success(
            function (response) {
                $scope.contentList[id] = response;  //以后其他的广告数据都可以放到该contentList中，通过下标区分
            }
        )
    }

})