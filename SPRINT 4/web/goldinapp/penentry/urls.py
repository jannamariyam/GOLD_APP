from django.conf.urls import url
from . import views
urlpatterns=[

    url(r'^android1/',views.mapiview1.as_view()),
    # url(r'^viewplan/',views.mapiview2.as_view()),


]