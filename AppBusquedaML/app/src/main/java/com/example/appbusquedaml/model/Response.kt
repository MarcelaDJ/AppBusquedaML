package com.example.appbusquedaml.model

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("available_sorts")
	val availableSorts: List<AvailableSortsItem?>? = null,

	@field:SerializedName("query")
	val query: String? = null,

	@field:SerializedName("available_filters")
	val availableFilters: List<AvailableFiltersItem?>? = null,

	@field:SerializedName("site_id")
	val siteId: String? = null,

	@field:SerializedName("paging")
	val paging: Paging? = null,

	@field:SerializedName("country_default_time_zone")
	val countryDefaultTimeZone: String? = null,

	@field:SerializedName("secondary_results")
	val secondaryResults: List<Any?>? = null,

	@field:SerializedName("sort")
	val sort: Sort? = null,

	@field:SerializedName("filters")
	val filters: List<FiltersItem?>? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null,

	@field:SerializedName("related_results")
	val relatedResults: List<Any?>? = null
)

data class PricesItem(

	@field:SerializedName("amount")
	val amount: Int? = null,

	@field:SerializedName("metadata")
	val metadata: Metadata? = null,

	@field:SerializedName("last_updated")
	val lastUpdated: String? = null,

	@field:SerializedName("regular_amount")
	val regularAmount: Any? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("conditions")
	val conditions: Conditions? = null,

	@field:SerializedName("exchange_rate_context")
	val exchangeRateContext: String? = null,

	@field:SerializedName("currency_id")
	val currencyId: String? = null
)

data class Conditions(

	@field:SerializedName("start_time")
	val startTime: Any? = null,

	@field:SerializedName("context_restrictions")
	val contextRestrictions: List<Any?>? = null,

	@field:SerializedName("eligible")
	val eligible: Boolean? = null,

	@field:SerializedName("end_time")
	val endTime: Any? = null
)

data class Ratings(

	@field:SerializedName("negative")
	val negative: Double? = null,

	@field:SerializedName("neutral")
	val neutral: Double? = null,

	@field:SerializedName("positive")
	val positive: Double? = null
)

data class Transactions(

	@field:SerializedName("canceled")
	val canceled: Int? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("period")
	val period: String? = null,

	@field:SerializedName("ratings")
	val ratings: Ratings? = null,

	@field:SerializedName("completed")
	val completed: Int? = null
)

data class Seller(

	@field:SerializedName("seller_reputation")
	val sellerReputation: SellerReputation? = null,

	@field:SerializedName("registration_date")
	val registrationDate: String? = null,

	@field:SerializedName("car_dealer")
	val carDealer: Boolean? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("real_estate_agency")
	val realEstateAgency: Boolean? = null,

	@field:SerializedName("permalink")
	val permalink: String? = null,

	@field:SerializedName("tags")
	val tags: List<String?>? = null,

	@field:SerializedName("eshop")
	val eshop: Eshop? = null
)

data class Metadata(
	val any: Any? = null
)

data class Country(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class Metrics(

	@field:SerializedName("cancellations")
	val cancellations: Cancellations? = null,

	@field:SerializedName("claims")
	val claims: Claims? = null,

	@field:SerializedName("delayed_handling_time")
	val delayedHandlingTime: DelayedHandlingTime? = null,

	@field:SerializedName("sales")
	val sales: Sales? = null
)

data class Paging(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("offset")
	val offset: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("primary_results")
	val primaryResults: Int? = null
)

data class AttributesItem(

	@field:SerializedName("attribute_group_id")
	val attributeGroupId: String? = null,

	@field:SerializedName("values")
	val values: List<ValuesItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("attribute_group_name")
	val attributeGroupName: String? = null,

	@field:SerializedName("value_id")
	val valueId: String? = null,

	@field:SerializedName("value_struct")
	val valueStruct: Any? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("source")
	val source: Int? = null,

	@field:SerializedName("value_name")
	val valueName: String? = null
)

data class Struct(

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("unit")
	val unit: String? = null
)

data class SellerAddress(

	@field:SerializedName("country")
	val country: Country? = null,

	@field:SerializedName("address_line")
	val addressLine: String? = null,

	@field:SerializedName("city")
	val city: City? = null,

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("comment")
	val comment: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("state")
	val state: State? = null,

	@field:SerializedName("zip_code")
	val zipCode: String? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null
)

data class Sort(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class ValueStruct(

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("unit")
	val unit: String? = null
)

data class State(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class Eshop(

	@field:SerializedName("seller")
	val seller: Int? = null,

	@field:SerializedName("eshop_rubro")
	val eshopRubro: Any? = null,

	@field:SerializedName("eshop_id")
	val eshopId: Int? = null,

	@field:SerializedName("nick_name")
	val nickName: String? = null,

	@field:SerializedName("site_id")
	val siteId: String? = null,

	@field:SerializedName("eshop_logo_url")
	val eshopLogoUrl: String? = null,

	@field:SerializedName("eshop_status_id")
	val eshopStatusId: Int? = null,

	@field:SerializedName("eshop_experience")
	val eshopExperience: Int? = null,

	@field:SerializedName("eshop_locations")
	val eshopLocations: List<Any?>? = null
)

data class Sales(

	@field:SerializedName("period")
	val period: String? = null,

	@field:SerializedName("completed")
	val completed: Int? = null
)

data class ResultsItem(

	@field:SerializedName("seller")
	val seller: Seller? = null,

	@field:SerializedName("original_price")
	val originalPrice: Any? = null,

	@field:SerializedName("stop_time")
	val stopTime: String? = null,

	@field:SerializedName("buying_mode")
	val buyingMode: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("sold_quantity")
	val soldQuantity: Int? = null,

	@field:SerializedName("available_quantity")
	val availableQuantity: Int? = null,

	@field:SerializedName("domain_id")
	val domainId: String? = null,

	@field:SerializedName("use_thumbnail_id")
	val useThumbnailId: Boolean? = null,

	@field:SerializedName("shipping")
	val shipping: Shipping? = null,

	@field:SerializedName("category_id")
	val categoryId: String? = null,

	@field:SerializedName("installments")
	val installments: Installments? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("official_store_id")
	val officialStoreId: Any? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("prices")
	val prices: Prices? = null,

	@field:SerializedName("accepts_mercadopago")
	val acceptsMercadopago: Boolean? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("address")
	val address: Address? = null,

	@field:SerializedName("catalog_product_id")
	val catalogProductId: String? = null,

	@field:SerializedName("sale_price")
	val salePrice: Any? = null,

	@field:SerializedName("seller_address")
	val sellerAddress: SellerAddress? = null,

	@field:SerializedName("tags")
	val tags: List<String?>? = null,

	@field:SerializedName("order_backend")
	val orderBackend: Int? = null,

	@field:SerializedName("condition")
	val condition: String? = null,

	@field:SerializedName("thumbnail_id")
	val thumbnailId: String? = null,

	@field:SerializedName("site_id")
	val siteId: String? = null,

	@field:SerializedName("attributes")
	val attributes: List<AttributesItem?>? = null,

	@field:SerializedName("listing_type_id")
	val listingTypeId: String? = null,

	@field:SerializedName("permalink")
	val permalink: String? = null,

	@field:SerializedName("currency_id")
	val currencyId: String? = null,

	@field:SerializedName("differential_pricing")
	val differentialPricing: DifferentialPricing? = null,

	@field:SerializedName("catalog_listing")
	val catalogListing: Boolean? = null
)

data class FiltersItem(

	@field:SerializedName("values")
	val values: List<ValuesItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class Claims(

	@field:SerializedName("period")
	val period: String? = null,

	@field:SerializedName("rate")
	val rate: Double? = null,

	@field:SerializedName("value")
	val value: Int? = null,

	@field:SerializedName("excluded")
	val excluded: Excluded? = null
)

data class Presentation(

	@field:SerializedName("display_currency")
	val displayCurrency: String? = null
)

data class DifferentialPricing(

	@field:SerializedName("id")
	val id: Int? = null
)

data class SellerReputation(

	@field:SerializedName("power_seller_status")
	val powerSellerStatus: String? = null,

	@field:SerializedName("level_id")
	val levelId: String? = null,

	@field:SerializedName("metrics")
	val metrics: Metrics? = null,

	@field:SerializedName("transactions")
	val transactions: Transactions? = null,

	@field:SerializedName("real_level")
	val realLevel: String? = null,

	@field:SerializedName("protection_end_date")
	val protectionEndDate: String? = null
)

data class Prices(

	@field:SerializedName("presentation")
	val presentation: Presentation? = null,

	@field:SerializedName("reference_prices")
	val referencePrices: List<Any?>? = null,

	@field:SerializedName("payment_method_prices")
	val paymentMethodPrices: List<Any?>? = null,

	@field:SerializedName("purchase_discounts")
	val purchaseDiscounts: List<Any?>? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("prices")
	val prices: List<PricesItem?>? = null
)

data class AvailableSortsItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class DelayedHandlingTime(

	@field:SerializedName("period")
	val period: String? = null,

	@field:SerializedName("rate")
	val rate: Double? = null,

	@field:SerializedName("value")
	val value: Int? = null,

	@field:SerializedName("excluded")
	val excluded: Excluded? = null
)

data class Installments(

	@field:SerializedName("amount")
	val amount: Double? = null,

	@field:SerializedName("quantity")
	val quantity: Int? = null,

	@field:SerializedName("rate")
	val rate: Double? = null,

	@field:SerializedName("currency_id")
	val currencyId: String? = null
)

data class ValuesItem(

	@field:SerializedName("struct")
	val struct: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("source")
	val source: Int? = null
)

data class Shipping(

	@field:SerializedName("mode")
	val mode: String? = null,

	@field:SerializedName("free_shipping")
	val freeShipping: Boolean? = null,

	@field:SerializedName("tags")
	val tags: List<String?>? = null,

	@field:SerializedName("logistic_type")
	val logisticType: String? = null,

	@field:SerializedName("store_pick_up")
	val storePickUp: Boolean? = null
)

data class Cancellations(

	@field:SerializedName("period")
	val period: String? = null,

	@field:SerializedName("rate")
	val rate: Double? = null,

	@field:SerializedName("value")
	val value: Int? = null,

	@field:SerializedName("excluded")
	val excluded: Excluded? = null
)

data class Excluded(

	@field:SerializedName("real_value")
	val realValue: Int? = null,

	@field:SerializedName("real_rate")
	val realRate: Double? = null
)

data class AvailableFiltersItem(

	@field:SerializedName("values")
	val values: List<ValuesItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class PathFromRootItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class Address(

	@field:SerializedName("city_name")
	val cityName: String? = null,

	@field:SerializedName("state_name")
	val stateName: String? = null,

	@field:SerializedName("state_id")
	val stateId: String? = null,

	@field:SerializedName("city_id")
	val cityId: Any? = null
)

data class City(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Any? = null
)
