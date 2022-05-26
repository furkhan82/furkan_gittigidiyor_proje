@api
Feature: Trello_testi

  Scenario: Create_board
    Given Send POST request for create "jj" board
    Then yazdirma
    Then okuma
    Then  Assert status code 200
    And Assert board name is "jj1"

  Scenario: Liste olusturmak
    Given Post List yapmak "furkanlistesi"


  Scenario: 1.Card olusturma
    Given kart olusturma 1 "furkanKarti1"


  Scenario: 2.Card olusturma
    Given kart olusturma 2 "furkanKarti2"


  Scenario: 1.Karti Silmek
    Given bir karti sil

  Scenario: 2.Karti Silmek
    Given iki karti sil