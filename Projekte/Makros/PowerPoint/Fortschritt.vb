Option Explicit
Public sld As Slide
Public shp As Shape
 
Sub EinfProbar()
 
    Dim AnzSeiten As Long
 
    AnzSeiten = ActivePresentation.Slides.Count
 
    For Each sld In ActivePresentation.Slides
        'AddShape Parameter(Form (1=Rechteck), Abstand von links, Abstand von oben, Breite, Höhe)
        Set shp = sld.Shapes.AddShape(1, 36, 500, 648 / AnzSeiten * sld.SlideNumber, 10)
        'Namensvergabe für den Progressbar; wird benötigt um den Balken später wieder löschen zu können.
        shp.Name = "ProBar" & sld.SlideNumber
        shp.Fill.ForeColor.RGB = RGB(0, 52, 104)
        shp.Fill.BackColor.RGB = RGB(0, 52, 104)
    Next
End Sub
 
Sub DelProbar()
    For Each sld In ActivePresentation.Slides
        For Each shp In sld.Shapes
            If shp.Name Like "ProBar*" Then
                shp.Delete
            End If
        Next
    Next
End Sub