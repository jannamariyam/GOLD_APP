from django.conf.urls import url
from . import views
urlpatterns=[
    url(r'^login',views.mapiview.as_view()),

]