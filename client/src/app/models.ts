export interface Artist {
    idArtist: string
    strArtist: string
    strLabel: string
    intFormedYear: string
    strStyle: string
    strGenre: string
    strBiographyEN: string
    strCountry: string;
    strArtistThumb: string
    strArtistLogo: string

}

export interface Albums {

    idAlbum: string
    strAlbum: string
    strArtist: string
    intYearReleased: string
    strAlbumCDart: string
    strDescriptionEN: string
}

export interface Username {
    
    username: string
}