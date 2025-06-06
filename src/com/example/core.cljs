(ns com.example.core
  (:require [uix.core :as uix :refer [defui $]]
            [uix.dom]))

(defui button [props]
  ($ :button.btn.btn-circle.w-10.h-10
     props))

(defui app []
  (let [[n set-n] (uix/use-state 0)]
    ($ :.flex.flex-col.justify-center.items-center.h-screen
       ($ :h1.text-6xl.mb-4
          {:style {:transform (str "rotate(" (* n 15) "deg)")}}
          "👋")
       ($ :h2.text-3xl.font-semibold "Hello UIx")
       ($ :.p-6
          ($ button {:on-click #(set-n dec)} "-")
          ($ :span.mx-4.text-xl {} n)
          ($ button {:on-click #(set-n inc)} "+")))))

(defonce root
  (uix.dom/create-root (js/document.getElementById "app")))

(defn render []
  (uix.dom/render-root
   ($ uix/strict-mode
      ($ app))
   root))

(defn ^:export init []
  (render))
