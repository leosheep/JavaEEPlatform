package cn.edu.xmu.restfuldemo.controller;

import cn.edu.xmu.restfuldemo.controller.vo.GoodsVo;
import cn.edu.xmu.restfuldemo.model.Goods;
import io.swagger.annotations.*;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cn.edu.xmu.restfuldemo.service.GoodsService;
import cn.edu.xmu.restfuldemo.util.ResponseUtil;

@Api(value = "商品API", tags = "商品API")
@RestController /*Restful的Controller对象*/
@RequestMapping(value = "/goods", produces = "application/json;charset=UTF-8")
public class GoodsController {

    private final Log logger = LogFactory.getLog(GoodsController.class);

    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "获得商品信息",  produces="application/json")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
    })
    @GetMapping("{id}")
    public Object getGoodsById(@PathVariable("id") Integer id) {

        Goods goods = goodsService.findById(id);
        return ResponseUtil.ok(goods);
    }

    @ApiOperation(value = "用商品名称搜索",  produces="application/json")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
    })
    @GetMapping("search")
    public Object searchGoodsByName(@RequestParam String name) {

        Goods goods = goodsService.searchByName(name);
        return ResponseUtil.ok(goods);
    }

    @ApiOperation(value = "新建商品",  produces="application/json")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
    })
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Object createGood(@Validated @RequestBody GoodsVo goodsVo){
        Goods new_goods = goodsService.createGoods(goodsVo);
        return ResponseUtil.ok(new_goods);
    }

    @ApiOperation(value = "修改商品",  produces="application/json")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
    })
    @PutMapping("{id}")
    public Object modiGood(@PathVariable Integer id, @RequestBody GoodsVo goodsVo){
        goodsService.modifyGoods(id, goodsVo);
        return ResponseUtil.ok();
    }

    @ApiOperation(value = "删除商品",  produces="application/json")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
    })
    @DeleteMapping("{id}")
    public Object delGoods(@PathVariable("id") Integer id) {

        goodsService.delGoods(id);
        return ResponseUtil.ok();
    }

}