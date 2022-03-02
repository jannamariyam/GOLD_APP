from django.conf.urls import url
from . import views
urlpatterns=[
    url(r'^register/',views.mapiview.as_view()),
    url(r'^editview/',views.mapiview1.as_view()),
    url(r'^update/',views.mapiview2.as_view()),
    url(r'^vcus/',views.vcustomer),
    url(r'^registercus/',views.post),
    url(r'^viewtr/(?P<idd>\w+)',views.viewtr,name="viewtr"),
# (?P<idd>\w+)

]