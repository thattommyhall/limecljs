(ns limecljs.core
  (:require
   [lime.Director :as lime.Director]
   [lime.Scene :as lime.Scene]
   [lime.Layer :as lime.Layer]
   [lime.Circle :as lime.Circle]
   [lime.Label :as lime.Label]
   [lime.animation.Spawn :as lime.animation.Spawn]
   [lime.animation.FadeTo :as lime.animation.FadeTo]
   [lime.animation.ScaleTo :as lime.animation.ScaleTo]
   [lime.animation.MoveTo :as lime.animation.MoveTo]))

(defn append-child [target child]
  (.appendChild target child))

(defn ^:export init []
  (let [director (js/lime.Director. (.-body js/document) 1024 768)
        scene (js/lime.Scene.)
        target (js/lime.Layer.)
        circle (js/lime.Circle.)
        lbl (js/lime.Label.)
        title (js/lime.Label.)
        ]
    (.setPosition target 512 384)
    (-> circle
        (.setSize 150 150)
        (.setFill 255 150 0))
    (-> lbl
        (.setSize 160 50)
        (.setFontSize 30)
        (.setText "Touch Me!"))
    (-> title
        (.setSize 800 70)
        (.setFontSize 60)
        (.setText "Now move me around!")
        (.setOpacity 0)
        (.setPosition 512 80)
        (.setFontColor "#999")
        (.setFill 200 100 0 0.1))
    (append-child target circle)
    (append-child target lbl)
    (append-child scene target)
    (append-child scene title)

    (.makeMobileWebAppCapable director)

    (.listen js/goog.events
             target
             (clj->js ["mousedown" "touchstart"])
             (fn [e]
               (.log js/console "blah")
               ;; Animate
               (.runAction target (lime.animation.Spawn.
                                   (-> (lime.animation.FadeTo. 0.5)
                                       (.setDuration 0.2))
                                   (-> (lime.animation.ScaleTo. 1.5)
                                       (.setDuration 0.8))))
               (.runAction title (lime.animation.FadeTo. 1))

               ;; let target follow mouse/finger
               (.startDrag e)

               ;; listen for end event
               (.swallow e (clj->js ["mouseup" "touchend"])
                         (fn []
                           (.runAction target (lime.animation.Spawn.
                                               (lime.animation.FadeTo. 1)
                                               (lime.animation.ScaleTo. 1)
                                               (lime.animation.MoveTo. 512 384)))
                           (.runAction title (lime.animation.FadeTo. 0))))))
    (.replaceScene director scene))


  )
