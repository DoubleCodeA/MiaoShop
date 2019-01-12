app.service('seckillService',function($http){
	this.findAll = function(){
		return $http.get('seckill/findAll.do');
	}

	//秒杀商品详情
	this.findOne = function(id){
		return $http.get('seckill/findOne.do?id='+id);
	}

	//秒杀下单
	this.saveSeckillOrder = function(id){
		return $http.get('seckill/saveSeckillOrder.do?goodsId='+id);
	}
})