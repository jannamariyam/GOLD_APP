from django.conf.urls import url
from temp import views
urlpatterns=[
    url(r'^adm/',views.adminhome),
    url(r'^login',views.login),

]