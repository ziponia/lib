package com.ziponia.st11.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSearchResponse implements Serializable {

    @XmlElement(name = "Products")
    private Products products;

    @Getter
    @ToString
    @XmlRootElement(name = "Products")
    public static class Products {

        @XmlElement(name = "TotalCount")
        private Integer totalCount;

        @XmlElement(name = "Product")
        private List<Product> products;

        @Getter
        @ToString
        @XmlRootElement(name = "Product")
        public static class Product {

            @XmlElement(name = "ProductCode")
            private String productCode;

            @XmlElement(name = "ProductName")
            private String productName;

            @XmlElement(name = "ProductPrice")
            private Integer productPrice;

            @XmlElement(name = "ProductImage")
            private String productImage;

            @XmlElement(name = "ProductImage100")
            private String productImage100;
            @XmlElement(name = "ProductImage110")
            private String productImage110;
            @XmlElement(name = "ProductImage120")
            private String productImage120;
            @XmlElement(name = "ProductImage130")
            private String productImage130;
            @XmlElement(name = "ProductImage140")
            private String productImage140;
            @XmlElement(name = "ProductImage150")
            private String productImage150;
            @XmlElement(name = "ProductImage170")
            private String productImage170;
            @XmlElement(name = "ProductImage200")
            private String productImage200;
            @XmlElement(name = "ProductImage250")
            private String productImage250;
            @XmlElement(name = "ProductImage270")
            private String productImage270;
            @XmlElement(name = "ProductImage300")
            private String productImage300;

            @XmlElement(name = "Text1")
            private String text1;

            @XmlElement(name = "Text2")
            private String text2;

            @XmlElement(name = "SellerNick")
            private String sellerNick;

            @XmlElement(name = "Seller")
            private String seller;

            @XmlElement(name = "SellerGrd")
            private String sellerGrd;

            @XmlElement(name = "Rating")
            private String rating;

            @XmlElement(name = "DetailPageUrl")
            private String detailPageUrl;

            @XmlElement(name = "SalePrice")
            private Integer salePrice;

            @XmlElement(name = "Delivery")
            private String delivery;

            @XmlElement(name = "ReviewCount")
            private Integer reviewCount;

            @XmlElement(name = "BuySatisfy")
            private Integer buySatisfy;

            @XmlElement(name = "MinorYn")
            private String minorYn;

            @XmlElement(name = "Benefit")
            private Benefit benefit;

            @Getter
            @ToString
            @XmlRootElement(name = "Benefit")
            public static class Benefit {

                @XmlElement(name = "Discount")
                private Integer discount;

                @XmlElement(name = "Mileage")
                private Integer mileage;
            }
        }
    }
}
