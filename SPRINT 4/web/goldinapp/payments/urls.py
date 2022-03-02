from django.conf.urls import url
from . import views
urlpatterns=[

    url(r'^android1/',views.mapiview1.as_view()),
    url(r'^android2/',views.mapiview2.as_view()),
    url(r'^android3/',views.mapiview3.as_view()),
    url(r'^viewtrans/',views.viewpayments),
    url('accept/(?P<idd>\w+)', views.accept, name='acc'),
    url(r'^reject/(?P<idd>\w+)', views.reject, name='rej'),

    # url(r'^viewplan/',views.mapiview2.as_view()),


]