app.controller("itemController",function($scope,$http){
	
	$scope.num = 1;

	//数量加减
	$scope.addNum=function(x){
		$scope.num+=x;
		if($scope.num<1){
			$scope.num=1;
		}		
	}

	$scope.specificationItems={};//记录用户选择的规格

	//用户选择规格存入到specificationItems的Map中
	$scope.selectSpecification=function(key,value){	
		$scope.specificationItems[key]=value;
		searchSku(); 
	}	

	//判断某规格选项是否被用户选中，判断key中保存的value是否一致，一致返回true
	$scope.isSelected=function(key,value){
		if($scope.specificationItems[key]==value){
			return true;
		}else{
			return false;
		}		
	}

	//加载默认的SKU
	$scope.sku={}; //skuList 将默认的选中的对象直接赋值给sku
	$scope.loadSku=function(){
			$scope.sku= skuList[0]; //为了让默认选中第一个
			$scope.specificationItems=JSON.parse(JSON.stringify($scope.sku.spec));
			//为了让SKU部分也是默认得值，进行的赋值
		}

	//查询
	searchSku=function(){
		for(var i=0;i< skuList.length;i++  ){
			if( matchObject (skuList[i].spec, $scope.specificationItems ) ){
				$scope.sku=skuList[i];
				return;
			}		
		}
	}


	//匹配两个对象是否相等
	matchObject=function(map1,map2){		
		for(var k in map1){
			if(map1[k]!=map2[k]	){
				return false;
			}				
		}
		for(var k in map2){
			if(map1[k]!=map2[k]	){
				return false;
			}				
		}
		return true;		
	}

	//将商品添加到购物车
	$scope.save = function () {
		//alert($scope.sku.id);
		$http.get('http://localhost:9107/cart/addItemToCartList.do?itemId='+$scope.sku.id+'&num='+$scope.num,{'withCredentials':true} ).success(
				function (response) {
					if(response.success){
						location.href="http://localhost:9107/cart.html";
					}else{
						alert(response.message);
					}
                }
		)
    }
});