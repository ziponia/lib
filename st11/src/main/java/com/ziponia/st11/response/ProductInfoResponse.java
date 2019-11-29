package com.ziponia.st11.response;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@ToString
@XmlRootElement(name = "ProductInfoResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInfoResponse {

    @XmlElement(name = "Product")
    private Product product;

    @Getter
    @ToString
    @XmlRootElement(name = "Product")
    public static class Product {

        @XmlElement(name = "ProductCode")
        private String productCode;

        @XmlElement(name = "ProductName")
        private String productName;

        @XmlElement(name = "ProductPrice")
        private String productPrice;

        @XmlElement(name = "BasicImage")
        private String basicImage;

        @XmlElement(name = "AddImage1")
        private String addImage1;

        @XmlElement(name = "AddImage2")
        private String addImage2;

        @XmlElement(name = "AddImage3")
        private String addImage3;

        @XmlElement(name = "ImageL300")
        private String imageL300;

        @XmlElement(name = "Point")
        private Integer point;

        @XmlElement(name = "Chip")
        private Integer chip;

        @XmlElement(name = "Installment")
        private String installment;

        @XmlElement(name = "ShipFee")
        private String shipFee;

        @XmlElement(name = "SellSatisfaction")
        private String sellSatisfaction;

        @XmlElement(name = "SellGrade")
        private String sellGrade;

        @XmlRootElement(name = "ProductPrice")
        public static class ProductPrice {

            @XmlElement(name = "Price")
            private String price;

            @XmlElement(name = "LowestPrice")
            private String lowestPrice;
        }
    }
}
