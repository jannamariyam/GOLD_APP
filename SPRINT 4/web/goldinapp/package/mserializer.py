from rest_framework import serializers
from .models import Fixed
class mserializer(serializers.ModelSerializer):

    class Meta:
        model=Fixed
        fields='__all__'