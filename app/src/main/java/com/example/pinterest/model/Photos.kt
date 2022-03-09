package com.example.pinterest.model

typealias Photos = ArrayList<Photo>

data class Photo (
    val id: String,
    val createdAt: String,
    val updatedAt: String,
    val promotedAt: String? = null,
    val width: Long,
    val height: Long,
    val color: String,
    val blurHash: String,
    val description: String? = null,
    val altDescription: String? = null,
    val urls: Urls,
    val links: PhotoLinks,
    val categories: List<Any?>,
    val likes: Long,
    val likedByUser: Boolean,
    val currentUserCollections: List<Any?>,
    val sponsorship: Sponsorship? = null,
    val topicSubmissions: TopicSubmissions,
    val user: User
)

data class PhotoLinks (
    val self: String,
    val html: String,
    val download: String,
    val downloadLocation: String
)

data class Sponsorship (
    val impressionUrls: List<String>,
    val tagline: String,
    val taglineURL: String,
    val sponsor: User
)

data class User (
    val id: String,
    val updatedAt: String,
    val username: String,
    val name: String,
    val firstName: String,
    val lastName: String? = null,
    val twitterUsername: String? = null,
    val portfolioURL: String? = null,
    val bio: String? = null,
    val location: String? = null,
    val links: UserLinks,
    val profileImage: ProfileImage,
    val instagramUsername: String? = null,
    val totalCollections: Long,
    val totalLikes: Long,
    val totalPhotos: Long,
    val acceptedTos: Boolean,
    val forHire: Boolean,
    val social: Social
)

data class UserLinks (
    val self: String,
    val html: String,
    val photos: String,
    val likes: String,
    val portfolio: String,
    val following: String,
    val followers: String
)

data class ProfileImage (
    val small: String,
    val medium: String,
    val large: String
)

data class Social (
    val instagramUsername: String? = null,
    val portfolioURL: String? = null,
    val twitterUsername: String? = null,
    val paypalEmail: Any? = null
)

data class TopicSubmissions (
    val actForNature: ActForNature? = null,
    val travel: ActForNature? = null,
    val nature: ActForNature? = null,
    val businessWork: BusinessWork? = null,
    val architecture: ActForNature? = null,
    val originalbydesign: BusinessWork? = null,
    val workFromHome: BusinessWork? = null,
    val streetPhotography: ActForNature? = null,
    val fashion: ActForNature? = null,
    val people: BusinessWork? = null
)

data class ActForNature (
    val status: String
)

data class BusinessWork (
    val status: String,
    val approvedOn: String
)

data class Urls (
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String,
    val smallS3: String
)
