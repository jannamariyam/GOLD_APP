from django.conf.urls import url
from . import views
urlpatterns=[
    url(r'^register',views.mapiview.as_view()),

]