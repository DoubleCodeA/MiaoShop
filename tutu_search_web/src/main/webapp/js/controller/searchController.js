
app.controller('searchController',function (searchService,$scope) {

    $scope.search=function () {
        $scope.searchMap.pageSize = $scope.paginationConf.itemsPerPage;
        $scope.searchMap.pageNo = $scope.paginationConf.currentPage;
        searchService.search($scope.searchMap).success(function (response) {
            $scope.list = response.rows;
            // alert(JSON.stringify(response))
            $scope.paginationConf.totalItems=response.total;
        })
    }
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.search();//重新加载
        }
    };
    $scope.init = function(){
        //$scope.searchMap={keywords:'手机'};
        $scope.searchMap = {
            // "keywords" : "手机",// 1,主查询条件 （关键词搜索条件）
            // "category" : "",// 2,分类查询参数
            // "brand" : "",	// 3，品牌参数
            "spec" : {},	// 4,规格属性参数
            "price" : "",	// 5,价格参数
            "sort" : "ASC",	// 6,排序
            "pageNo" : 1,		// 7,页码
            "pageSize" : 10	//8.每页显示记录数
        };
        $scope.search();
    }



    $scope.addFilterCondition = function (key,value) {
        $scope.searchMap.keywords='';
        if (key=="category" || key == "brand"|| key == "price"){
            $scope.searchMap[key] = value;
        } else {
            $scope.searchMap.spec[key] = value;
        }
        $scope.search();
    }

    $scope.removeSearchItem=function(key){
        if(key=="category" ||  key=="brand" || key=="price"){//如果是分类或品牌价格
            $scope.searchMap[key]="";
        }else{//否则是规格
            delete $scope.searchMap.spec[key];//移除此属性
        }
        //调用搜索方法
        $scope.search();
    }

    $scope.sortSearch=function(sort){
        $scope.searchMap.sort=sort;
        $scope.search();
    }

})