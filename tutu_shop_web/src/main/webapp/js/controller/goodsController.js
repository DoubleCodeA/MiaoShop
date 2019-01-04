 //控制层 
app.controller('goodsController' ,function($scope,$controller   ,$location,uploadService,goodsService,itemCatService,typeTemplateService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		goodsService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		goodsService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){
		var id = $location.search()['id'];
		if (id == null){
		    return;
        }
		goodsService.findOne(id).success(
			function(response){
				$scope.entity= response;
                //向富文本编辑器添加商品介绍
                editor.html($scope.entity.goodsDesc.introduction);
                //显示图片列表
                $scope.entity.goodsDesc.itemImages=
                    JSON.parse($scope.entity.goodsDesc.itemImages);
                //显示扩展属性
                $scope.entity.goodsDesc.customAttributeItems=
                    JSON.parse($scope.entity.goodsDesc.customAttributeItems);
                //读取规格
                $scope.entity.goodsDesc.specificationItems=
                    JSON.parse($scope.entity.goodsDesc.specificationItems);
                //准备SKU信息
                for( var i=0;i<$scope.entity.itemList.length;i++ ){
                    $scope.entity.itemList[i].spec = JSON.parse( $scope.entity.itemList[i].spec);
                }
			}
		);				
	}
	
	//保存 
	$scope.save=function(){
        $scope.entity.goodsDesc.introduction = editor.html(); //获取富文本编辑器的内容
		var serviceObject;//服务层对象  				
		if($scope.entity.goods.id!=null){//如果有ID
			serviceObject=goodsService.update( $scope.entity ); //修改  
		}else{
			serviceObject=goodsService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
                    alert(response.message);
					// $scope.entity={};
                    // editor.html("");
                    location.href="goods.html";
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		goodsService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		goodsService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}



	$scope.findItemCatOneList=function () {
		itemCatService.findParentId(0).success(function (response) {
			$scope.itemCastOneList=response;
        })
    }

    //根据一级分类的id获取二级分类列表数据  $watch查看变量是否发生改变，如果改变就触发，两个参数：查看的变量名的字符串，function(改变值,改变之前的值)
    $scope.$watch('entity.goods.category1Id',function (newValue, oldValue) {
        itemCatService.findParentId(newValue).success(
            function (response) {
                $scope.itemCastTwoList = response;
            }
        )
    })

    //根据二级显示三级分类的列表数据
    $scope.$watch('entity.goods.category2Id',function (newValue, oldValue) {
        itemCatService.findParentId(newValue).success(
            function (response) {
                $scope.itemCastThreeList = response;
            }
        )
    })

    //根据三级分类选择后获取分类对象，从分类对象上获取模版id
    $scope.$watch('entity.goods.category3Id',function (newValue, oldValue) {
        itemCatService.findOne(newValue).success(
            function (response) {
                $scope.entity.goods.typeTemplateId = response.typeId; //itemCat对象.typeId,直接封装到商品对象上

            }
        )
    })

    //根据模版id获取模版对象
    $scope.$watch('entity.goods.typeTemplateId',function (newValue,oldValue) {
        typeTemplateService.findOne(newValue).success(
            function (response) { //模版对象
                $scope.typeTemplate = response; //无法循环对象中的json字符串，需要处理再循环
                $scope.typeTemplate.brandIds = JSON.parse($scope.typeTemplate.brandIds);
                if ($location.search()['id']==null){
                    $scope.entity.goodsDesc.customAttributeItems = JSON.parse($scope.typeTemplate.customAttributeItems);
                }
            }
        );
        typeTemplateService.findSpecList(newValue).success(function (response) {
                $scope.specList=response;
        })

    })
	
	$scope.uploadFile = function () {
		uploadService.uploadFile().success(function (response) {
			if (response.success){
				$scope.image_entity.url=response.message;
			}else {
				alert(response.message);
			}
        }).error(function () {
			alert("上传发生错误");
        })
    }
    $scope.init=function(){
        $scope.findItemCatOneList();
        $scope.entity={goodsDesc:{itemImages:[],specificationItems:[]}};
    }
    $scope.addImage=function () {
		$scope.entity.goodsDesc.itemImages.push($scope.image_entity);
    }
    $scope.deleImage = function(index) {
        $scope.entity.goodsDesc.itemImages.splice(index, 1);
    }

    $scope.updateSpecAttribute=function ($event,name,value) {
		var object = $scope.searchObjectByKey($scope.entity.goodsDesc.specificationItems,'attributeName',name);
		if (object != null){
			if ($event.target.checked){
				object.attributeValue.push(value);
			}else {
				object.attributeValue.splice(object.attributeValue.indexOf(value),1);
				if (object.attributeValue.length==0)
				{
					$scope.entity.goodsDesc.specificationItems.splice(
						$scope.entity.goodsDesc.specificationItems.indexOf(object),1
					);
				}
			}
		}else {
			$scope.entity.goodsDesc.specificationItems.push(
                {"attributeName":name,"attributeValue":[value]}
            );
		}
    }

    $scope.addColumn = function (list,columnName,columnValues) {
        var newList=[];
        for (var i = 0; i < list.length; i++){
            var oldRow = list[i];
            for (var j =0; j < columnValues.length; j++){
                var newRow = JSON.parse(JSON.stringify(oldRow));
                newRow.spec[columnName] = columnValues[j];
                newList.push(newRow);
            }
        }
        return newList;
    }

    $scope.createItemList=function () {
		$scope.entity.itemList=[{spec:{},price:0,num:99999,status:'0',isDefault:'0'}];
		var items = $scope.entity.goodsDesc.specificationItems;
		for (var i = 0; i < items.length; i++){
			$scope.entity.itemList=$scope.addColumn($scope.entity.itemList,items[i].attributeName,items[i].attributeValue);
		}
    }



    $scope.itemCatList=[];//商品分类列表

    $scope.findItemCatList=function(){
        itemCatService.findAll().success(
            function(response){
                for(var i=0;i<response.length;i++){
                    $scope.itemCatList[response[i].id]=response[i].name;
                }
            }
        );
    }

    $scope.checkAttributeValue=function (specName,optionName) {
        var items = $scope.entity.goodsDesc.specificationItems;
        var object = $scope.searchObjectByKey(items,'attributeName',specName);
        if (object == null){
            return false;
        }else {
            if (object.attributeValue.indexOf(optionName)>=0){
                return true;
            } else {
                return false;
            }
        }
    }

    $scope.soldOut=function(){
        //获取选中的复选框
        goodsService.soldOut( $scope.selectIds).success(
            function(response){
                if(response.success){
                    $scope.reloadList();//刷新列表
                    $scope.selectIds=[];
                }
            }
        );
    }

    $scope.goodsOnline=function(){
        //获取选中的复选框
        goodsService.goodsOnline( $scope.selectIds).success(
            function(response){
                if(response.success){
                    $scope.reloadList();//刷新列表
                    $scope.selectIds=[];
                }
            }
        );
    }

    // 更改状态
    $scope.updateStatus = function(status) {
        goodsService.updateStatus($scope.selectIds, status).success(
            function(response) {
                if (response.success) {// 成功
                    $scope.reloadList();// 刷新列表
                    $scope.selectIds = [];// 清空 ID 集合
                } else {
                    alert(response.message);
                }
            });
    }
});	
