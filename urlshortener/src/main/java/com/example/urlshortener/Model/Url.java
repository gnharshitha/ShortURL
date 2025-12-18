public Url {
    
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String shortKey;

    @Column(length = 2000)
    private String longUrl;

    private LocalDateTime createdAt;
    private int clickCount;

    // ✅ THIS IS THE CONSTRUCTOR BEING CALLED
    public UrlMapping(String shortKey, String longUrl) {
        this.shortKey = shortKey;
        this.longUrl = longUrl;
        this.createdAt = LocalDateTime.now();
        this.clickCount = 0;
    }

    // Required by JPA
    public UrlMapping() {}
}
}