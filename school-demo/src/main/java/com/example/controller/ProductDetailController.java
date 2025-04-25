package com.example.controller;

import com.example.entity.ProductDetail;
import com.example.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productDetail")
public class ProductDetailController {

    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetail> getProductDetail(@PathVariable("id") Integer id) {
        ProductDetail productDetail = productDetailService.findById(id);
        if (productDetail != null) {
            // 查看商品时增加浏览量
            productDetailService.updateViewCount(id);
            return ResponseEntity.ok(productDetail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<ProductDetail> getProductDetail() {
        System.out.println("getProductDetail");
        ProductDetail productDetail = productDetailService.findById(1);
        if (productDetail != null) {
            return ResponseEntity.ok(productDetail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductDetail>> getProductDetailByCategory(@PathVariable("category") String category) {
        List<ProductDetail> productDetail = productDetailService.findByCategory(category);
        if (productDetail != null) {
            return ResponseEntity.ok(productDetail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/updateData/{id}")
    public ResponseEntity<ProductDetail> updateProductDetail(@PathVariable int id,@RequestParam String type,
                                                             @RequestParam String value) {
        ProductDetail productDetail=productDetailService.findById(id);
        if (type.equals("favoriteCount")) {
            if (value.equals("add")){
                productDetail.setFavoriteCount(productDetail.getFavoriteCount()+1);
            }else if (value.equals("subtract")){
                productDetail.setFavoriteCount(productDetail.getFavoriteCount()-1);
            }
        } else if (type.equals("likeCount")) {
            if (value.equals("add")){
                productDetail.setLikeCount(productDetail.getLikeCount()+1);
            }else if (value.equals("subtract")){
                productDetail.setLikeCount(productDetail.getLikeCount()-1);
            }
        } else if (type.equals("purchaseCount")) {
            if (value.equals("add")){
                productDetail.setPurchaseCount(productDetail.getPurchaseCount()+1);
            }else if (value.equals("subtract")){
                productDetail.setPurchaseCount(productDetail.getPurchaseCount()-1);
            }
        }
        int updated = productDetailService.update(productDetail);
        return ResponseEntity.ok(productDetail);
    }
    @PostMapping
    public ResponseEntity<ProductDetail> createProductDetail(@RequestBody ProductDetail productDetail) {
        ProductDetail created = productDetailService.insert(productDetail);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDetail> updateProductDetail(
            @PathVariable("id") Integer id,
            @RequestBody ProductDetail productDetail) {
        productDetail.setId(id);
        int updated = productDetailService.update(productDetail);
        return ResponseEntity.ok(productDetail);
    }

    @PutMapping("/{id}/like")
    public ResponseEntity<Void> likeProduct(@PathVariable("id") Integer id) {
        productDetailService.updateLikeCount(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/favorite")
    public ResponseEntity<Void> favoriteProduct(@PathVariable("id") Integer id) {
        productDetailService.updateFavoriteCount(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/init")
    public ResponseEntity<String> initData() {
        // 创建一个测试产品详情
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(1);
        productDetail.setFavoriteCount(0);
        productDetail.setLikeCount(0);
        productDetail.setPurchaseCount(0);
        productDetail.setViewCount(0);
        
        try {
            productDetailService.insert(productDetail);
            return ResponseEntity.ok("初始化数据成功");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("初始化数据失败: " + e.getMessage());
        }
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Integer> getDetailIdByProductId(@PathVariable("productId") Integer productId) {
        Integer detailId = productDetailService.getDetailIdByProductId(productId);
        return detailId != null ? ResponseEntity.ok(detailId) : ResponseEntity.notFound().build();
    }
}
