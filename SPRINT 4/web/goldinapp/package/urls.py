from django.conf.urls import url
from package import views
urlpatterns=[
    url(r'^packview/', views.packview),
    url(r'^fixed/', views.fixamount),
    url(r'^variable/', views.varamount),
    url(r'^android1/',views.mapiview1.as_view()),
    url(r'^android2/',views.mapiview2.as_view())
    # url(r'^view_packages/', views.view_packages),
    # url(r'^update_type/(?P<idd>\w+)', views.update_type,name='update_type'),

]